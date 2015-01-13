package com.acn.webapp.eloa.server;

import java.io.PrintStream;
import java.io.Serializable;



public class BaseException extends RuntimeException implements Serializable
{
    private String m_strErrorMsg = null;
    private boolean m_bCasedByException = false;
    private String m_strStackTrace;
        
    /**
     * Default Constructor for BaseException
     */
    public BaseException()
    {
        captureStackTrace(null);
    }


    public BaseException(String strMessage)
    {
        m_strErrorMsg = strMessage;
        captureStackTrace(null);
    }


    public BaseException(String strErrorMsg, Throwable objException)
    {
        String strCausedBy = null;
        if (objException.getCause()!= null)
            strCausedBy = objException.getCause().getMessage();
        m_strErrorMsg = strErrorMsg + ": " + objException.getMessage() + ((strCausedBy==null)?"":", caused by " + strCausedBy);
        captureStackTrace(objException);
    }

    private void captureStackTrace(Throwable objException) {       
        StringBuffer sb = null;
        //getting current stack trace 
        java.io.StringWriter out = new java.io.StringWriter();
        super.printStackTrace( new java.io.PrintWriter( out ) );
        
        // checking if there is "caused by" exception
        if( objException == null ) 
        {
            //we need all current the stack trace
            sb = new StringBuffer( out.toString() );
        }
        else
        {
            //we need just first line of the current stack trace
            String strBuffer  = out.toString();
            sb=new StringBuffer(strBuffer.substring(0,strBuffer.indexOf("\n")+1));

            //then we add the "caused by" stack trace
            objException.printStackTrace( new java.io.PrintWriter( out ) );
            //and append it to our line
            sb.append(out.getBuffer());
        }
        m_strStackTrace = sb.toString();
    }

    /**
     * Returns the message for the exception
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
        return m_strErrorMsg;
    }

    /**
     * Sets the message for the exception
     * @param strNewMessage
     */
    public void setMessage(String strNewMessage) 
    {
        this.
        m_strErrorMsg = strNewMessage;
    }

    /**
     * Method returns stacktrace as a String
     * @return java.lang.String
     */
    public java.lang.String getStackTraceString() {
        return m_strStackTrace;
    }

    /** 
     * Print the stack trace to standard error
     */
    public void printStackTrace() {
        
        System.err.println( m_strStackTrace );
    }

    /** 
     * Print the stack trace to print stream
     * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
     */
    public void printStackTrace(PrintStream objPrintStream) {
        
        objPrintStream.println( m_strStackTrace );
    }

}
