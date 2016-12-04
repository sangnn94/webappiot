#include<SoftwareSerial.h>
SoftwareSerial gsmSerial(2,3);
SoftwareSerial zigbeeSerial(4,5);
String nodeData = "";
void setup() {
  Serial.begin(38400);
  gsmSerial.begin(38400);
  zigbeeSerial.begin(38400);
  gsmSerial.listen();
  gsmSerial.write("AT+GSN\r\n");
  String IMEI =  gsmSerial.readString();
  delay(3000);
  gsmSerial.write("AT+SAPBR=3,1,APN,m-wap\r\n");
  delay(3000);
  gsmSerial.write("AT+SAPBR=1,1\r\n");
  delay(3000);
  gsmSerial.write("AT+HTTPINIT\r\n");
  delay(3000);
  gsmSerial.write("AT+HTTPPARA=URL,http://webappiot-openshift-web-app-iot.44fs.preview.openshiftapps.com/postData\r\n");
  delay(3000);
}

void loop() {
  
  if(gsmSerial.available()){
    
    Serial.write(gsmSerial.read());
  }
  configure();
  delay(60000);
}
void configure(){
  gsmSerial.write("AT+HTTPPARA=CONTENT,application/json\r\n");
  delay(3000);
  zigbeeSerial.listen();
  if(zigbeeSerial.available()){
   nodeData = zigbeeSerial.readString();
   gsmSerial.listen();
   gsmSerial.write("AT+HTTPDATA=2048,5000\r\n");
  delay(3000); 
  String json = "{\"id\": \"ATD+GSN0932484056\", \"nodeID\": \"2\", \"value\": \"" + nodeData+ "\", \"date\":\"date test\"}\r\n";
  char result[2048];
  json.toCharArray(result,2048);
  gsmSerial.write(result);
  delay(3000);
  gsmSerial.write("AT+HTTPACTION=1\r\n");
  }
}

