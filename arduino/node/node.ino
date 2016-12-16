#include <SoftwareSerial.h>
SoftwareSerial zigbeeSerial(2,3);
byte pinMQ = A0;
boolean alarmCO = false;
// Adjust vRef to be the true supply voltage in mV.
float vRef = 5000.0;
float RL = 10.0;  //  load resistor value in k ohms
float ratioRsRo = 10.0;  //  default value 10 k ohms.  Revised during calibration.
const float Ro_clean_air_factor = 10.0;

float mV = 0.0;
unsigned long samples = 0;
float coPpm = 0.0;
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
  getData();
  //delay(1000);
}

void getData(){
  mV = 0.0;
  samples = 0.0;
  for(int i = 500; i>0; i--){
    mV += Get_mVfromADC(pinMQ);
    samples += 1;
    delay(2);
  }
  mV = mV / (float) samples;
  ratioRsRo = CalcRsFromVo(mV) / Ro_clean_air_factor;
  coPpm = GetCOPpmForRatioRsRo(ratioRsRo);
  char result[] = ""; // Buffer big enough for 7-character float
  dtostrf(coPpm, 7, 2, result);
  //char deviceId[]= "id";
  //zigbeeSerial.write(deviceId); 
  Serial.print("CO: ");
  Serial.println(coPpm);    
  zigbeeSerial.write(result);                                                                                            
  
}

float CalcRsFromVo(float Vo) {
  //  Vo = sensor output voltage in mV.
  //  VRef = supply voltage, 5000 mV
  //  RL = load resistor in k ohms
  //  The equation Rs = (Vc - Vo)*(RL/Vo)
  float Rs = (vRef - Vo) * (RL / Vo);  
  return Rs;
}

float GetCOPpmForRatioRsRo(float RsRo_ratio) {
  //  for the curve of:  Rs/Ro = 22.073 * (CO ppm) ^ -0.66659
  float ppm;
  ppm = pow((RsRo_ratio/22.073), (1/-0.66659));
  return  ppm;
}

float Get_mVfromADC(byte AnalogPin) {
    // read the value from the sensor:
    int ADCval = analogRead(AnalogPin);  
    float mV = ADCval * (vRef / 1024.0);
    return mV;
}
