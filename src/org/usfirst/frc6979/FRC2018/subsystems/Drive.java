package org.usfirst.frc6979.FRC2018.subsystems;



import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc6979.FRC2018.OI;
import org.usfirst.frc6979.FRC2018.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc6979.FRC2018.subsystems.*;



/**
 * m
 */
public class Drive extends Subsystem {

	/* I don't think we need this? DJH
	 * 
    private final WPI_TalonSRX frontLeft = RobotMap.drivefrontLeft;
    private final WPI_TalonSRX backLeft = RobotMap.drivebackLeft;
    private final WPI_TalonSRX frontRight = RobotMap.drivefrontRight;
    private final WPI_TalonSRX backRight = RobotMap.drivebackRight;
    
    private final SpeedControllerGroup driveLeft = RobotMap.driveLeft;
    private final SpeedControllerGroup driveRight = RobotMap.driveRight;
    */
	
    
    private final DifferentialDrive differentialDrive = RobotMap.driveDifferentialDrive;
    OI oi = new OI();
    Elevator elevator = new Elevator();
	
    private double joyYLeftRamped;
    private double joyYLeftRampTime;
    private double joyYRightRamped;
    private double joyYRightRampTime;
    
    @Override
    public void initDefaultCommand() {


        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    
    public void periodic() {
    	
    	
    	
    	// Put code here to be run every loop
    	
    	// Instantiate OI
    	
    	/*differentialDrive.tankDrive(oi.ramp(oi.getJoyYLeft(), this.joyYLeftRamped, 0.1, 1, this.joyYLeftRampTime), 
    			oi.ramp(oi.getJoyYRight(), this.joyYRightRamped, 0.1, 1, this.joyYRightRampTime));
    	*/
    	differentialDrive.tankDrive(oi.getJoyYLeft()/2, oi.getJoyYRight()/2);   
    	//TODO: If power sent to motor, check for limit switch
    	elevator.setElevatorSpeed((-oi.getRightTrigger())/2);
}
   

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void stop() {
    	differentialDrive.tankDrive(0,0);
    }
}

