package com.acn.webapp.eloa.server;


public class AcnException extends BaseException
{

	public AcnException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param strMessage
	 */
	public AcnException(String strMessage)
	{
		super(strMessage);
		// TODO Auto-generated constructor stub
	}


	public AcnException(String strErrorMsg, Throwable objException)
	{
		super(strErrorMsg, objException);
		
	}

}
