#include<SoftwareSerial.h>
SoftwareSerial mySerial(2,3);
void setup() {
  Serial.begin(9600);
  mySerial.begin(9600);
  while(!mySerial){
    ;
  }
  
  mySerial.write("AT+GSN\r\n");
  String IMEI =  mySerial.readString();
  delay(3000);
  mySerial.write("AT+SAPBR=3,1,APN,m-wap\r\n");
  delay(3000);
  mySerial.write("AT+SAPBR=1,1\r\n");
  delay(3000);
  mySerial.write("AT+HTTPINIT\r\n");
  delay(3000);
  mySerial.write("AT+HTTPPARA=URL,http://webappiot-openshift-web-app-iot.44fs.preview.openshiftapps.com/postData\r\n");
  delay(3000);
}

void loop() {
  
  /*if(mySerial.available()){
    
    Serial.write(mySerial.read());
  
  }*/
  configure();
  delay(60000);
}
void configure(){
  mySerial.write("AT+HTTPPARA=CONTENT,application/json\r\n");
  delay(3000);
  mySerial.write("AT+HTTPDATA=2048,5000\r\n");
  delay(3000);
  mySerial.write("{\"id\": \"ATD+GSN0932484056\", \"nodeID\": \"2\", \"value\": \"12 24 48 96\", \"date\":\"date test\"}\r\n");
  delay(3000);
  mySerial.write("AT+HTTPACTION=1\r\n");
}

