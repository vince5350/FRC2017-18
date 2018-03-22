package org.usfirst.frc6979.FRC2018.commands;

import org.usfirst.frc6979.FRC2018.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

public class LiftDown extends Command {

	Lift lift = new Lift();
	
	private double downSpeed = 0.1;
	
	public LiftDown() {
		
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		if(!lift.getBottomLimit()) {
			lift.setLiftSpeed(this.downSpeed);
		} else {
			lift.setLiftSpeed(0);
		}
	}
	
	@Override
	protected boolean isFinished() {
		if (lift.getBottomLimit()){
        	return true;
        } else {
        	return false;
        }
	}
	
	@Override
	protected void end() {
		lift.setLiftSpeed(0);
	}
	
	@Override
	protected void interrupted() {
	}

}
