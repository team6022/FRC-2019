package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.LiftPistonsActiveFront;
import frc.robot.RobotMap;


/**
 * Lift and drops bottom pistons
 */
public class LiftPistonsFront extends Subsystem {

	static DoubleSolenoid DoubleSolenoidFront = new DoubleSolenoid(RobotMap.BackLiftPistonsForwardChannel, RobotMap.BackLiftPistonsReverseChannel);

	public LiftPistonsFront()
	{
		super();
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new LiftPistonsActiveFront());
	}

	/**
	* Active toggles the front pistons
	*
	* @param isActive is piston in or out
	*/
	public void Active(XboxController Branjoy)
	{
		boolean isActive = (Branjoy.getTriggerAxis(Hand.kRight) >= 0.9);
		DoubleSolenoidFront.set((isActive) ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
		SmartDashboard.putBoolean("FrontLiftPistonsOut", isActive);
	}


}
