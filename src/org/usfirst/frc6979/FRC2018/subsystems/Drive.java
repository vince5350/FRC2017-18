package org.usfirst.frc6979.FRC2018.subsystems;



import org.usfirst.frc6979.FRC2018.OI;
import org.usfirst.frc6979.FRC2018.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Drive extends Subsystem {
	
    
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
    	
    	//Motor Output Maximums
    	differentialDrive.setMaxOutput(0.9);
        RobotMap.elevator.setNeutralMode(NeutralMode.Brake);

    	
    	
    	/*
    	 *  DRIVE COMMAND
    	 */
    	differentialDrive.tankDrive(oi.getJoyYLeft(), oi.getJoyYRight());   
    	
    	
    	
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
    		RobotMap.winchMotor.set(0.6);
    	} else {
    		RobotMap.winchMotor.set(0);
    	}
    	
    	SmartDashboard.putString("Solenoid State", arm.getArmState());
}
    
    public void stop() {
    	differentialDrive.tankDrive(0,0);
    }
}

