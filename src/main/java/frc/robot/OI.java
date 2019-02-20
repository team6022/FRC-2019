package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.*;

public class OI
{
	// final Joystick Branjoy = new Joystick(0);
	final XboxController Branjoy = new XboxController(0);
	final XboxController Sarajoy = new XboxController(1);

	// Buttons for Sarajoy
	Button XBoxA = new JoystickButton(Sarajoy, 1);
	Button XBoxY = new JoystickButton(Sarajoy, 4);
	POVButton DPadUp = new POVButton(Sarajoy, 0);
	POVButton DPadDown = new POVButton(Sarajoy, 180);

	// Buttons for Branjoy
	Button XBoxB = new JoystickButton(Branjoy, 2);
	Button XBoxX = new JoystickButton(Branjoy, 3);
	Button XBoxLB = new JoystickButton(Branjoy, 5);
	Button XBoxRB = new JoystickButton(Branjoy, 6);
	Button XBoxBack = new JoystickButton(Branjoy, 7);
	Button XBoxStart = new JoystickButton(Branjoy, 8);
	Button XBoxL3 = new JoystickButton(Branjoy, 9);
	Button XBoxR3 = new JoystickButton(Branjoy, 10);


	public XboxController getJoystickBran()
	{
		return Branjoy;
	}

	public OI()
	{

		// Velcro Piston
		XBoxR3.whenPressed(new VelcroPistonsToggle());

		// Vision Alignment
		XBoxA.whileHeld(new VisionAlign());

		// Pull Ball In
		XBoxLB.whileHeld(new Intake(0.75));
		XBoxLB.whenReleased(new Intake(0.0));

		// Shoot Ball Out
		XBoxRB.whileHeld(new Intake(-1.0));
		XBoxRB.whenReleased(new Intake(0.0));


		// Start/Stop Shuffleboard Record
		XBoxStart.whenPressed(new RecordStart());
		XBoxBack.whenPressed(new RecordStop());

		// D Pad Up & Down
		DPadUp.whenPressed(new ExtendingArmMove());
		DPadDown.whenPressed(new ExtendingArmMove());
	}

}
