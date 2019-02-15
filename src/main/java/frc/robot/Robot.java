package frc.robot;

// import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.VelcroPistons;
import frc.robot.subsystems.ExtendingArm;
import frc.robot.subsystems.RhinoTracks;
import frc.robot.subsystems.LiftPistons;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot
{

	public static OI OI;
	public static VelcroPistons VelcroPistons;
	public static RhinoTracks RhinoTracks;
	public static ExtendingArm ExtendingArm;
	public static LiftPistons LiftPistons;

	public String gameData;

	Command autonomousCommand;
	// SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */

	public void robotInit()
	{

		// ShuffleBoard Sets
		SmartDashboard.setDefaultBoolean("VelcroPistonOut", false);
		SmartDashboard.setDefaultBoolean("VelcroPistonsOut", false);
		SmartDashboard.setDefaultBoolean("FrontLiftPistonsOut", false);
		SmartDashboard.setDefaultBoolean("BackLiftPistonsOut", false);
		SmartDashboard.setDefaultNumber("victorSP1", 0);
		SmartDashboard.setDefaultNumber("victorSP2", 0);
		SmartDashboard.setDefaultNumber("victorSP3", 0);
		SmartDashboard.setDefaultNumber("victorSP4", 0);


		// starts and streams camera data
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);



		// this will return a string from the "Game Data" field in the Driver Station
		gameData = DriverStation.getInstance().getGameSpecificMessage();


		// loads robots controls
		RhinoTracks = new RhinoTracks();
		VelcroPistons = new VelcroPistons();
		// LiftPistons = new LiftPistons();
		OI = new OI(); // keep OI() at the bottom

	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	public void disabledInit()
	{

	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	public void autonomousInit()
	{
		autonomousCommand.start();

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
		// LiveWindow.run();
	}

	public void operatorControl()
	{
		while (isOperatorControl() && isEnabled())
		{
			Timer.delay(0.005);
		}
	}
}
