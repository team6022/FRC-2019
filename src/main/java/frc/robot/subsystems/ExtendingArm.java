package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

/**
 * Add description here
 */
public class ExtendingArm extends Subsystem {

	static TalonSRX TalonRight = new TalonSRX(RobotMap.LowerArmRight);
	static TalonSRX TalonLeft = new TalonSRX(RobotMap.LowerArmLeft);


	public ExtendingArm()
	{
		super();
	}

	public void initDefaultCommand()
	{

	}

	public void MoveLowerArm(Joystick Branjoy)
	{

		Double speed = 0.40; // you probably don't want to go over 0.40

		TalonLeft.setNeutralMode(NeutralMode.Coast);
		TalonRight.setNeutralMode(NeutralMode.Coast);
		TalonLeft.set(ControlMode.PercentOutput, -speed);
		TalonRight.set(ControlMode.PercentOutput, speed);

	}


	public void StopLower(Joystick Branjoy)
	{
		TalonLeft.set(ControlMode.PercentOutput, 0.0);
		TalonRight.set(ControlMode.PercentOutput, 0.0);
		TalonLeft.setNeutralMode(NeutralMode.Brake);
		TalonRight.setNeutralMode(NeutralMode.Brake);
	}
}
