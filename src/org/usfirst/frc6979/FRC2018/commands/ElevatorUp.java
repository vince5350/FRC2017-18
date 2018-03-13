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
import org.usfirst.frc6979.FRC2018.Robot;
import org.usfirst.frc6979.FRC2018.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorUp extends Command {
	
	Elevator elevator = new Elevator();
	
	private double upspeed = 0.2;


    public ElevatorUp() {
    	


    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	if (!elevator.getTopLimit()) {
    		elevator.setElevatorSpeed(this.upspeed);
    	} else {
    		elevator.setElevatorSpeed(0);
    	}
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
