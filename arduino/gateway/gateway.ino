#include <SoftwareSerial.h>
SoftwareSerial zigbeeSerial(4,5);
void setup() {
  // put your setup code here, to run once:
  Serial.begin(38400);
  zigbeeSerial.begin(38400);
  while (!Serial) {
    ; 
  }
   while (!zigbeeSerial) {
    ; 
  }
}

void loop() {
  // put your main code here, to run repeatedly:
  if(zigbeeSerial.available()){
    Serial.write(zigbeeSerial.read());
  }
}
