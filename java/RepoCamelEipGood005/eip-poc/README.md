Small comparison of Apache Camel and Spring Integration (webinar video record in russian: http://www.anymeeting.com/jtalks/EB56DA81894D)

Camel part:

1. Data is provided by the file in camelSource directory or by putting something into console

2. Data is transformed (enriched)

3. Then message is directed to our own class that just logs all the headers

4. As a final step message is sent to ActiveMQ broker


Spring Integration part:

1. Message is recieved from JMS broker

2. Message goes to our bean where it logs all the headers

3. Then we transform (enrich) it

4. And then put it to siTarget directory

