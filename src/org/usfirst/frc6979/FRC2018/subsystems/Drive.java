package org.usfirst.frc6979.FRC2018.subsystems;



import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc6979.FRC2018.OI;
import org.usfirst.frc6979.FRC2018.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc6979.FRC2018.subsystems.*;


public class Drive extends Subsystem {
	
    
    private final DifferentialDrive differentialDrive = RobotMap.driveDifferentialDrive;
    OI oi = new OI();
    Elevator elevator = new Elevator();
    Arm arm = new Arm();
	
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
    	
    	
    	
    	// Put code here to be run every loop
    	
    	// Instantiate OI
    	
    	/*
    	 *  DRIVE COMMAND
    	 */
    	
    	
    	/*
    	 * differentialDrive.tankDrive(oi.ramp(oi.getJoyYLeft(), this.joyYLeftRamped, 0.1, 1, this.joyYLeftRampTime), 
    	 *	oi.ramp(oi.getJoyYRight(), this.joyYRightRamped, 0.1, 1, this.joyYRightRampTime));
    	 */
    	differentialDrive.tankDrive(oi.getJoyYLeft()/2, oi.getJoyYRight()/2);   
    	
    	
    	/*
    	 *  ELEVATOR COMMAND
    	 */
    	
    	//TODO: If power sent to motor, check for limit switch
    	elevator.setElevatorSpeed((-oi.getRightTrigger())/2);
    	
    	//TODO: 		Figure out which one is which
    	if((RobotMap.elevator.get() < 0 || RobotMap.elevator.get() > 0) && Elevator.getTopLimit() ) {
    		elevator.setElevatorSpeed((oi.getRightTrigger()/2));    		
    	}
    	
    	if((RobotMap.elevator.get() < 0 || RobotMap.elevator.get() > 0) && !Elevator.getTopLimit() ) {
    		elevator.setElevatorSpeed((-oi.getLeftTrigger()/2));    		
    	}
    	
    	
    	/*
    	 *  ARM COMMAND
    	 */
    	
    	//TODO: TEST!!!
    	if(oi.getButtonX2()) {
    		arm.setArmSpeed(1);
    	}
    	
    	if(oi.getButtonY2()) {
    		arm.setArmSpeed(-1);
    	} else{ 
    		arm.setArmSpeed(0);
    	}
    	
    	
    	//Close arm with right dpad, open with left
    	if(oi.getDpadRight()) {
    		arm.closeArm(true);
    	}
    	if(oi.getDpadLeft()) {
    		arm.closeArm(false);
    	}
    	
    	
}
    
    public void stop() {
    	differentialDrive.tankDrive(0,0);
    }
}

