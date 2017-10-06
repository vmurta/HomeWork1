import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
	
public class Main {
	
	final static double radius = 2.25;
	final static double pi = 3.141592653589793;
	static double displacement = 0.0;
	
	
	public static void main(String[] args) {
		
		RegulatedMotor mA = new EV3MediumRegulatedMotor(MotorPort.A);
		RegulatedMotor mB = new EV3MediumRegulatedMotor(MotorPort.B);
		EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
		mA.synchronizeWith(new RegulatedMotor[] {mB});
		
		//TODO: Move Forward 150 cm, stop, and beep
		System.out.println("Moving forward into the great big world!");
		double distanceToGo = 15.0;
		double numRotations = ( distanceToGo / (radius * 2 * pi));
		int angle = (int) (360.0 * numRotations);
		
		mA.startSynchronization();
		mA.rotate(angle);
		mB.rotate(angle);
		mA.endSynchronization();
		
		displacement = distanceToGo;
		Sound.beep();
		System.out.println("Waiting to proceed to next step");
		Button.ENTER.waitForPressAndRelease();
		
		
		//TODO: press button, stop when sonar reads 45 cm, beep
		System.out.println("Moving forward into the great big world!");
		
		Sound.beep();
		Button.ENTER.waitForPressAndRelease();
		//TODO: press button, go until hit wall, return to 45 cm from wall
		
		
		
		mA.close();
		mB.close();
	}
	

}
