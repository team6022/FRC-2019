package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftPistonsActiveBack;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Lift and drops bottom pistons
 */
public class LiftPistonsBack extends Subsystem {

	static DoubleSolenoid DoubleSolenoidBack = new DoubleSolenoid(RobotMap.FrontLiftPistonsForwardChannel, RobotMap.FrontLiftPistonsReverseChannel);


	public LiftPistonsBack()
	{
		super();
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new LiftPistonsActiveBack());
	}


	/**
	* FrontPistonsActive toggles the back pistons
	*/
	public void Active(XboxController Branjoy)
	{
		boolean isActive = (Branjoy.getTriggerAxis(Hand.kLeft) >= 0.9);
		DoubleSolenoidBack.set((isActive) ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
		SmartDashboard.putBoolean("FrontLiftPistonsOut", isActive);
	}
}
