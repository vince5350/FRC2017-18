package org.usfirst.frc6979.FRC2018.subsystems;



import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc6979.FRC2018.OI;
import org.usfirst.frc6979.FRC2018.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc6979.FRC2018.subsystems.*;

import com.ctre.phoenix.motorcontrol.NeutralMode;


public class Drive extends Subsystem {
	
	private Timer robotTimer = new Timer();

    private final DifferentialDrive differentialDrive = RobotMap.driveDifferentialDrive;
    OI oi = new OI();
    Elevator elevator = new Elevator();
    Arm arm = new Arm();
    Lift lift = new Lift();
    
    private double LIFT_SPEED = 1;
	
    /*
    private double joyYLeftRamped;
    private double joyYLeftRampTime;
    private double joyYRightRamped;
    private double joyYRightRampTime; */
    
    @Override
    public void initDefaultCommand() {


        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    
    public void periodic() {
    	//SmartDashboard.getNumber("Pneumatic Pressure", RobotMap.compressorArm.getCompressorCurrent());    	
    	// Put code here to be run every loop
    	// Instantiate OI
    	robotTimer.start();
    	//Motor Output Maximums
    	differentialDrive.setMaxOutput(0.8);
        RobotMap.elevator.setNeutralMode(NeutralMode.Brake);

    	
    	
    	/*
    	 *  DRIVE COMMAND
    	 */
    	differentialDrive.tankDrive(oi.getJoyYLeft()/1.5, oi.getJoyYRight()/1.5);   
    	
    	
    	//Auto Test
    	//TODO COMMENT OUT!!!!
    	if(oi.getStart()) {
    		robotTimer.reset();
    		if(robotTimer.get() < 3) {
    			differentialDrive.tankDrive(0.5, 0.5);
    		}
    	}
    	
    	/*
    	 *  ELEVATOR COMMAND
    	 */
    	
    	//TODO: If power sent to motor, check for limit switch
    	//elevator.setElevatorSpeed((-oi.getRightTrigger())/1.5);
    	
    	//TODO: 		Figure out which one is which
    	if(/*(RobotMap.elevator.get() < 0 || RobotMap.elevator.get() > 0) && Elevator.getTopLimit()*/ oi.getRightTrigger() > 0.2 ) {
    		elevator.setElevatorSpeed(0);    		
    	}
    	
    	else if(/*(RobotMap.elevator.get() < 0 || RobotMap.elevator.get() > 0) && !Elevator.getTopLimit()*/oi.getLeftTrigger() > 0.2 ) {
    		elevator.setElevatorSpeed(-0.5);    		
    	} 
    	
    	
    	/*
    	 *  LIFT COMMAND
    	 */
    	
    	//Up
    	if(oi.getLeftBumper() && Lift.getTopLimit() ) {
    		lift.setLiftSpeed(-LIFT_SPEED);
    	}
    	//Down
    	else if(oi.getRightBumper() && !Lift.getBottomLimit()) {
    		lift.setLiftSpeed(LIFT_SPEED);
    	} else {
    		lift.setLiftSpeed(0);
    	}
    	
    	
    	
    	/*
    	 *  ARM COMMAND
    	 */
    	
    	//TODO: TEST!!!
    	if(oi.getButtonA()) {
    		arm.setArmSpeed(-1);
    	}
    	
    	else if(oi.getButtonB()) {
    		arm.setArmSpeed(1);
    	} else {
    		arm.setArmSpeed(0);
    	}
    	
    	
    	
    	//Close arm with right dpad, open with left
    	if(oi.getButtonY()) {
    		arm.closeArm(Value.kReverse);
    	}
    	else if(oi.getButtonX()) {
    		arm.closeArm(Value.kForward);
    	} 
    	
    	
    	if(oi.getSelect()) {
    		RobotMap.winchMotor.set(0.3);
    	} else {
    		RobotMap.winchMotor.set(0);
    	}
    	
    	SmartDashboard.putString("Solenoid State", arm.getArmState());
}
    
    public void stop() {
    	differentialDrive.tankDrive(0,0);
    }
}

