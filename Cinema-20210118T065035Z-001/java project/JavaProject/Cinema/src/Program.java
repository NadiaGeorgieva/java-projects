public class Program {
	/* Connection
	   CLIENTS       CLIENT_ID PRIMARYKEY FNAME,LNAME,ADDRESS
	   MEDIA         MEDIA_ID PRIMARYKEY TITLE,CREATED
	   CLIENTS_MEDIA CLIENT_ID FOREGNKEY,MEDIA_ID FOREGNKEY DATERERENT,PRICE
	   
	   db tables creation in sql server for java h2
	   
	   CREATE TABLE CLIENTS(
       CLIENT_ID IDENTITY PRIMARY KEY NOT NULL,
       FNAME NVARCHAR(15) NOT NULL,
       LNAME NVARCHAR(15) NOT NULL,
       ADDRESS NVARCHAR(50) NOT NULL
       );
       ......................................
       CREATE TABLE MEDIA(
       MEDIA_ID IDENTITY PRIMARY KEY NOT NULL,
       TITLE NVARCHAR(30) NOT NULL,
       CREATED DATETIME NOT NULL
       );
       ........................................
       CREATE TABLE CLIENTS_MEDIA(
       ID IDENTITY NOT NULL PRIMARY KEY,
       CLIENT_ID  INT,
       MEDIA_ID INT,
       DATE_RENT DATETIME NOT NULL,
       PRICE DECIMAL(6,2),
       FOREIGN KEY (CLIENT_ID) REFERENCES CLIENTS(CLIENT_ID) ON DELETE CASCADE,
       FOREIGN KEY (MEDIA_ID) REFERENCES MEDIA(MEDIA_ID) ON DELETE CASCADE
       );
	*/
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MyFrame myFrame=new MyFrame();
	}

}
