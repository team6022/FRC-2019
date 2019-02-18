package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveTrack;


/**
* Controls all RhinoTrack driving
*/
public class RhinoTracks extends Subsystem
{

	static VictorSP SP1 = new VictorSP(RobotMap.SP1Channel);
	static VictorSP SP2 = new VictorSP(RobotMap.SP2Channel);
	static VictorSP SP3 = new VictorSP(RobotMap.SP3Channel);
	static VictorSP SP4 = new VictorSP(RobotMap.SP4Channel);

	public RhinoTracks()
	{
		super();
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new DriveTrack());
	}


	/**
	* DriveJoystick allows for driving capabilities using the Joystick input.
	*/
	public void DriveJoystick(XboxController Branjoy)
	{
		Double speedDrive = 1.0;
		Double speedTurn = 1.0;
		Double turnThreshhold = 0.30;
		Double deadzone = 0.23;


		// check to see if we need to be turning left or right
		if (Branjoy.getY(Hand.kLeft) >= turnThreshhold || Branjoy.getY(Hand.kLeft) <= -turnThreshhold) {
			if (deadzone >= Branjoy.getY(Hand.kLeft) || -deadzone <= Branjoy.getY(Hand.kLeft))
				Drive(Branjoy.getY(Hand.kLeft) * speedDrive);
		} else {
			if (deadzone >= Branjoy.getX(Hand.kLeft) || -deadzone <= Branjoy.getX(Hand.kLeft))
				Turn(Branjoy.getX(Hand.kLeft) * speedTurn);
		}

	}

	/**
	* Drive moves the robot forwards or backwards
	*
	* @param speed how fast to go - Positive speed means forward, negative means backwards
	*/
	public void Drive(Double speed)
	{
		SP1.set(-speed);
		SP2.set(-speed);
		SP3.set(speed);
		SP4.set(speed);

		UpdateSmartDashboard();
	}

	/**
	* Turn moves the robot forwards or backwards
	*
	* @param speed what direction to turn - Positive speed means right, negative means left
	*/
	public void Turn(Double speed)
	{
		SP1.set(speed);
		SP2.set(speed);
		SP3.set(speed);
		SP4.set(speed);

		UpdateSmartDashboard();
	}

	/**
	* Makes sure the {@link SmartDashboard} is updated with the latest victorSP values
	*/
	private void UpdateSmartDashboard() {
		SmartDashboard.putNumber("victorSP/SP1", -SP1.get());
		SmartDashboard.putNumber("victorSP/SP2", -SP2.get());
		SmartDashboard.putNumber("victorSP/SP3", SP3.get());
		SmartDashboard.putNumber("victorSP/SP4", SP4.get());
	}

}
