#include<SoftwareSerial.h>
SoftwareSerial gsmSerial(2,3);
SoftwareSerial zigbeeSerial(4,5);
String nodeData = "000";
void setup() {
  Serial.begin(38400);
  zigbeeSerial.begin(38400);
  gsmSerial.begin(38400);
  gsmSerial.write("AT+GSN\r\n");
  String IMEI =  gsmSerial.readString();
  Serial.println(IMEI);
  delay(3000);
  Serial.println("set up network");
  gsmSerial.write("AT+SAPBR=3,1,APN,m-wap\r\n");
  delay(3000);
  Serial.println("active bearer");
  gsmSerial.write("AT+SAPBR=1,1\r\n");
  delay(3000);
  Serial.println("init hhtp");
  gsmSerial.write("AT+HTTPINIT\r\n");
  delay(3000);
  zigbeeSerial.listen();
  while(!zigbeeSerial.isListening()){
    ;
  }
  
}

void loop() {
  configure();
  delay(60000);
}

void configure(){
    
    if(zigbeeSerial.available()){
      Serial.println("set URL");
      gsmSerial.write("AT+HTTPPARA=URL,http://webappiot-openshift-web-app-iot.44fs.preview.openshiftapps.com/postData\r\n");
      delay(3000);
      Serial.println("set content ");
      gsmSerial.write("AT+HTTPPARA=CONTENT,application/json\r\n");
      delay(3000);
      Serial.println("set data ");
      gsmSerial.write("AT+HTTPDATA=2048,5000\r\n");
      Serial.println("input data");
      delay(3000); 
      String json = "{\"id\": \"ATD+GSN0932484056\", \"nodeID\": \"2\", \"value\": \"" + nodeData + "\", \"date\":\"date test\"}\r\n";
      Serial.println(json);
      gsmSerial.write("{\"id\": \"ATD+GSN0932484056\", \"nodeID\": \"2\", \"value\": \"");
      while(zigbeeSerial.available()){
        gsmSerial.write(zigbeeSerial.read());
      }
      gsmSerial.write("\", \"date\":\"date test\"}\r\n");
      delay(3000);
      Serial.println("post ");
      gsmSerial.write("AT+HTTPACTION=1\r\n");
      Serial.println("finish ");
    }
}

