package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.commands.ExtendingArmMove;
import frc.robot.RobotMap;


/**
 * Controls extending arm position
 */
public class ExtendingArm extends Subsystem {

	static TalonSRX TalonRight = new TalonSRX(RobotMap.ExtendingArmRight);
	static TalonSRX TalonLeft = new TalonSRX(RobotMap.ExtendingArmLeft);


	public ExtendingArm()
	{
		super();
	}


	public void initDefaultCommand()
	{

		setDefaultCommand(new ExtendingArmMove());

		// invert so we don't have to pass it negative numbers
		TalonLeft.setInverted(true);

		// Make right the slave and left the master (until right encoder gets fixed)
		TalonRight.follow(TalonLeft);

		// reset starting position to 0
		TalonLeft.setSelectedSensorPosition(0);
		TalonRight.setSelectedSensorPosition(0);

		// toggle neutralmode mode break or coast
		boolean isBreakMode = true;
		TalonLeft.setNeutralMode((isBreakMode) ? NeutralMode.Brake : NeutralMode.Coast);
		TalonRight.setNeutralMode((isBreakMode) ? NeutralMode.Brake : NeutralMode.Coast);

		// might be useful? ¯\_(ツ)_/¯ idk
		TalonLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 30);
		TalonRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 30);

	}


	/**
	* Use Joystick to move
	*/
	public void JoystickMove(XboxController Branjoy)
	{

		// set up an artificial joystick lift so that the bucket can maintain position
		Double artificialLift = 0.34;

		// list is only needed if the talon position is above 648. If the lift is added when we are below that, the bucket will move upwards on its own.
		if (TalonLeft.getSelectedSensorPosition() < 648.0) artificialLift = 0.0;

		// run move
		Move(Branjoy.getY(Hand.kRight) + -artificialLift);
	}

	/**
	* Move Extending Arm Motion
	*/
	public void Move(double speed)
	{

		// Pick different speeds depending on whether you are going up or down.
		// You probably don't want to go over 0.40
		Double speedMaxUp = 0.40;
		Double speedMaxDown = 0.20; // <-fix this

		// Turnery statement to pick correct speed.
		Double speedMax = (speed > 0)
			? speedMaxUp
			: speedMaxUp;

		// Move those Talons
		TalonLeft.set(ControlMode.PercentOutput, speed * speedMax);
		TalonRight.set(ControlMode.PercentOutput, speed * speedMax);

		UpdateSmartDashboard();
	}


	public void MovePosition(Integer position)
	{
		TalonLeft.set(ControlMode.MotionMagic, position);
		TalonRight.set(ControlMode.MotionMagic, position);

		System.out.println(position);

		UpdateSmartDashboard();
	}



	/**
	* Makes sure the {@link SmartDashboard} is updated with the latest values
	*/
	private void UpdateSmartDashboard() {
		SmartDashboard.putNumber("ExtendingArm/TalonLeft", TalonLeft.getSelectedSensorPosition());
		SmartDashboard.putNumber("ExtendingArm/TalonRight", TalonRight.getSelectedSensorPosition());
	}
}
