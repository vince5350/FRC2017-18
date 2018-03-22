package org.usfirst.frc6979.FRC2018.commands;

import org.usfirst.frc6979.FRC2018.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

public class LiftUp extends Command {

	Lift lift = new Lift();
	
	private double upSpeed = 0.1;
	
	public LiftUp() {
		
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		if(!lift.getTopLimit()) {
			lift.setLiftSpeed(this.upSpeed);
		} else {
			lift.setLiftSpeed(0);
		}
	}
	
	@Override
	protected boolean isFinished() {
		if (lift.getTopLimit()){
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

