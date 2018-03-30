package org.usfirst.frc6979.FRC2018.subsystems;

import org.usfirst.frc6979.FRC2018.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	private final WPI_TalonSRX leftArm = RobotMap.leftArm;
	private final Solenoid solenoidArm = RobotMap.solenoidArm;
	
	@Override
	protected void initDefaultCommand() {
		
	}

	public void setArmSpeed(double speed) {
		this.leftArm.set(speed);
	}
	
	
	//True = closed
	public void closeArm(boolean closed) {
		this.solenoidArm.set(closed);
	}
}
