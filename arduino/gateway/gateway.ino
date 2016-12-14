#include<SoftwareSerial.h>
SoftwareSerial zigbeeSerial(4,5);
SoftwareSerial gsmSerial(2,3);
String nodeData = "000";
char gatewayGps;
char gatewayId;
void setup() {
  Serial.begin(38400);
  zigbeeSerial.begin(38400);
  gsmSerial.begin(38400);
  gsmSerial.write("AT+GSN\r\n");
  gatewayId =  gsmSerial.read();
  Serial.println(gatewayId);
  delay(3000);
  Serial.println("set up network");
  gsmSerial.write("AT+SAPBR=3,1,APN,m-wap\r\n");
  delay(3000);
  Serial.println("active bearer");
  gsmSerial.write("AT+SAPBR=1,1\r\n");
  delay(3000);
  Serial.println("get location");
  clearGsmSerialBuffer();
  gsmSerial.write("AT+CIPGSMLOC=1,1\r\n");
  delay(10000);
  gatewayGps = gsmSerial.read();
  Serial.println(gatewayGps);
  delay(3000);
  Serial.println("init http");
  gsmSerial.write("AT+HTTPINIT\r\n");
  delay(3000);
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
  gsmSerial.write("{\"id\": \"");
  gsmSerial.write(gatewayId);
  gsmSerial.write("\", \"gps\": \"");
  gsmSerial.write(gatewayGps);
  gsmSerial.write("\"");
  delay(3000);
  Serial.println("post gps locaton");
  gsmSerial.write("AT+HTTPACTION=1\r\n");
  zigbeeSerial.listen();
  while(!zigbeeSerial.isListening()){
    ;
  }
  
}
void clearBuffer(){
  clearGsmSerialBuffer();
  clearZigbeeSerialBuffer();
}
void clearGsmSerialBuffer(){
   while(gsmSerial.available()){
     gsmSerial.read();
  }
}

void clearZigbeeSerialBuffer(){
   while(zigbeeSerial.available()){
    zigbeeSerial.read();
  }
}
void loop() {
  //configure();
  delay(3000);
  Serial.println("looping");
  Serial.println(gsmSerial.available());
}

void configure(){
    if(zigbeeSerial.available()){
      Serial.println("set URL");
      gsmSerial.write("AT+HTTPPARA=URL,http://webappiot-openshift-web-app-iot.44fs.preview.openshiftapps.com/gps\r\n");
      delay(3000);
      Serial.println("set content ");
      gsmSerial.write("AT+HTTPPARA=CONTENT,application/json\r\n");
      delay(3000);
      Serial.println("set data ");
      gsmSerial.write("AT+HTTPDATA=2048,5000\r\n");
      Serial.println("input data");
      delay(3000); 
      nodeData = zigbeeSerial.readString();
      Serial.println("CO = " + nodeData + " ppm");
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

