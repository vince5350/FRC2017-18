package org.usfirst.frc6979.FRC2018.subsystems;


import org.usfirst.frc6979.FRC2018.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem{

	 
    private final DigitalInput liftHighLimit = RobotMap.elevatorHighLimit;
    private final WPI_TalonSRX lift = RobotMap.lift;
    private final DigitalInput liftLowLimit = RobotMap.elevatorLowLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
   public boolean getTopLimit(){
    	return this.liftHighLimit.get();
   }
   
   public void setLiftSpeed(double speed) {
	   this.lift.set(speed);
   }
   
   
   public boolean getBottomLimit() {
	   return this.liftLowLimit.get();
   } 

}
