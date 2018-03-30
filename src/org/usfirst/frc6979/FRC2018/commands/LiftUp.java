package org.usfirst.frc6979.FRC2018.commands;

import org.usfirst.frc6979.FRC2018.subsystems.Lift;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftUp extends Command {

	Lift lift = new Lift();
	
	private double upSpeed = -0.5;
	
	public LiftUp() {
		
	}
	
    // Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}
    // Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double speed;
		SmartDashboard.putBoolean("LU Active", true);
		if(lift.getTopLimit()) {
			speed = this.upSpeed;
		} else {
			speed = 0;
		}
		lift.setLiftSpeed(speed);
		SmartDashboard.putNumber("Lift Motor Speed", speed);
	}
	
    // Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (lift.getTopLimit()){
        	return true;
        } else {
        	return false;
        }
	}
	
    // Called once after isFinished returns true
	@Override
	protected void end() {
		lift.setLiftSpeed(0);
	}
	
	// Called when another command which requires one or more of the same
    // subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}