package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add description here
 */
public class ExtendingArm extends Subsystem {

	static TalonSRX TalonRight = new TalonSRX(RobotMap.LowerArmRight);
	static TalonSRX TalonLeft = new TalonSRX(RobotMap.LowerArmLeft);

	static VelcroPistons vp = new VelcroPistons();


	public ExtendingArm()
	{
		super();
	}

	public void initDefaultCommand()
	{
	}

	public void MoveLowerArm()
	{

		Double speed = 0.40; // you probably don't want to go over 0.40

		TalonLeft.set(ControlMode.PercentOutput, -speed);
		TalonRight.set(ControlMode.PercentOutput, speed);
		System.out.println(TalonLeft.getSelectedSensorPosition());
		if (TalonLeft.getSelectedSensorPosition() >= 1670) {
			vp.Toggle();
			TalonLeft.set(ControlMode.PercentOutput, 0.0);
			TalonRight.set(ControlMode.PercentOutput, 0.0);
		}

	}

	public void StopLower()
	{
		TalonLeft.set(ControlMode.PercentOutput, 0.0);
		TalonRight.set(ControlMode.PercentOutput, 0.0);
	}
}
