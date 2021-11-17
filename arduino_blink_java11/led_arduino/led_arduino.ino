char comando;
#define led 13
boolean Status = 0, x=0;

void setup() {
  Serial.begin(9600);
  pinMode(led,OUTPUT);
  digitalWrite(led, LOW);
}

void loop() {
  if(x == 1) {
    blink();
  }
  
  if (Serial.available() > 0) {
    
    comando = Serial.read();
   
    if (comando =='a'){
      digitalWrite(led, HIGH);
      x=0;
      
    }
    if(comando =='b') {
      digitalWrite(led, LOW);
      x=0;
    }
    if(comando == 'c') {
      x=1;
    }
    
    Serial.println("Dado: ");
    Serial.println(comando);
  }
  
}

void blink(){
  Status = !Status;
      digitalWrite(led, Status);
      delay(200);
}
