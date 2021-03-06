// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc6979.FRC2018.commands;


import org.usfirst.frc6979.FRC2018.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorUp extends Command {
	
	Elevator elevator = new Elevator();
	
	private double upSpeed = -0.5;

    public ElevatorUp() {
    	

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    	double speed;
    	SmartDashboard.putBoolean("EU Active", true);
    	if (elevator.getTopLimit()) {
    		speed = this.upSpeed;
    	} else {
    		speed = 0;
    	}
    	elevator.setElevatorSpeed(speed);
    	SmartDashboard.putNumber("Motor Speed", speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	    if (elevator.getTopLimit()){
    	      	return true;
    	    } else {
    	      	return false;
    	    }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	elevator.setElevatorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}