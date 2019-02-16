package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * Add description here
 */
public class LiftPistons extends Subsystem {

	static DoubleSolenoid DSFront = new DoubleSolenoid(RobotMap.BackLiftPistonsForwardChannel, RobotMap.BackLiftPistonsReverseChannel);
	static DoubleSolenoid DSBack = new DoubleSolenoid(RobotMap.FrontLiftPistonsForwardChannel, RobotMap.FrontLiftPistonsReverseChannel);

	public LiftPistons()
	{
		super();
	}

	public void initDefaultCommand()
	{

	}

	public void BackPistonsOut(Joystick Branjoy)
	{
		DSFront.set(DoubleSolenoid.Value.kForward);
		SmartDashboard.putBoolean("BackLiftPistonsOut", false);
	}

	public void BackPistonsIn(Joystick Branjoy)
	{
		DSFront.set(DoubleSolenoid.Value.kReverse);
		SmartDashboard.putBoolean("BackLiftPistonsOut", true);

	}

	public void FrontPistonsOut(Joystick Branjoy)
	{
		DSBack.set(DoubleSolenoid.Value.kForward);
		SmartDashboard.putBoolean("FrontLiftPistonsOut", false);
	}

	public void FrontPistonsIn(Joystick Branjoy)
	{
		DSBack.set(DoubleSolenoid.Value.kReverse);
		SmartDashboard.putBoolean("FrontLiftPistonsOut", true);
	}
}
