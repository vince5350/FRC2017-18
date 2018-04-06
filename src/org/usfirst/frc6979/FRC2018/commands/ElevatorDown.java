package org.usfirst.frc6979.FRC2018.commands;

import org.usfirst.frc6979.FRC2018.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorDown extends Command {
	
	Elevator elevator = new Elevator();
	
	double downSpeed = 0.2;

	public ElevatorDown() {

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	double speed;
    	SmartDashboard.putBoolean("ED Active", true);
    	/*if (elevator.getBottomLimit()) {
    		speed = this.downSpeed;
    	} else {
    		speed = 0;
    	} */ speed = this.downSpeed;
    	elevator.setElevatorSpeed(speed);
    	SmartDashboard.putNumber("Elevator Motor Speed", speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    /*	if (elevator.getBottomLimit()) {
    		return true;
    	} else {
    		return false;
    	} */ return false;
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