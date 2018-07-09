package org.usfirst.frc6979.FRC2018.subsystems;

import org.usfirst.frc6979.FRC2018.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	private final WPI_TalonSRX leftArm = RobotMap.leftArm;
	private final DoubleSolenoid solenoidArm = RobotMap.solenoidArm;
	
	@Override
	protected void initDefaultCommand() {
		
	}

	public void setArmSpeed(double speed) {
		this.leftArm.set(speed);
	}
	
	
	//True = closed
	public void closeArm(Value value) {
		this.solenoidArm.set(value);
	}
	
	public String getArmState() {

	if(this.solenoidArm.get() == Value.kForward) {
		return "Forward";
	} else if(this.solenoidArm.get() == Value.kReverse) {
		return "Reverse";
	} else {
		return "Null";
	}

	}
}
