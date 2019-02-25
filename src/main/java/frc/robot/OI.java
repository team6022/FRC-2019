package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.*;

public class OI
{

	final XboxController Branjoy = new XboxController(0);

	// arcade controls only support up to 12 buttons per player, we need 15, so we'll be using 2
	final Joystick Sarjoy1 = new Joystick(1);
	final Joystick Sarjoy2 = new Joystick(2);


	// Inputs for Branjoy
	Button XBoxA = new JoystickButton(Branjoy, 1);
	Button XBoxB = new JoystickButton(Branjoy, 2);
	Button XBoxX = new JoystickButton(Branjoy, 3);
	Button XBoxY = new JoystickButton(Branjoy, 4);
	Button XBoxLB = new JoystickButton(Branjoy, 5);
	Button XBoxRB = new JoystickButton(Branjoy, 6);
	Button XBoxBack = new JoystickButton(Branjoy, 7);
	Button XBoxStart = new JoystickButton(Branjoy, 8);
	Button XBoxL3 = new JoystickButton(Branjoy, 9);
	Button XBoxR3 = new JoystickButton(Branjoy, 10);
	POVButton XBoxDPadUp = new POVButton(Branjoy, 0);
	POVButton XBoxDPadRight = new POVButton(Branjoy, 90);
	POVButton XBoxDPadDown = new POVButton(Branjoy, 180);
	POVButton XBoxDPadLeft = new POVButton(Branjoy, 270);


	// numbers might need to be adjusted depending how many inputs are used on controller 1 and controller 2
	Button Arcade1 = new JoystickButton(Sarjoy1, 1);
	Button Arcade2 = new JoystickButton(Sarjoy1, 2);
	Button Arcade3 = new JoystickButton(Sarjoy1, 3);
	Button Arcade4 = new JoystickButton(Sarjoy1, 4);
	Button Arcade5 = new JoystickButton(Sarjoy1, 5);
	Button Arcade6 = new JoystickButton(Sarjoy1, 6);
	Button Arcade7 = new JoystickButton(Sarjoy1, 7);
	Button Arcade8 = new JoystickButton(Sarjoy1, 8);
	Button Arcade9 = new JoystickButton(Sarjoy1, 9);
	Button Arcade10 = new JoystickButton(Sarjoy1, 10);
	Button Arcade11 = new JoystickButton(Sarjoy1, 11);
	Button Arcade12 = new JoystickButton(Sarjoy1, 12);
	Button Arcade13 = new JoystickButton(Sarjoy2, 1);
	Button Arcade14 = new JoystickButton(Sarjoy2, 2);
	Button Arcade15 = new JoystickButton(Sarjoy2, 3);


	public XboxController getJoystickBran()
	{
		return Branjoy;
	}

	public Joystick getJoystickSar1()
	{
		return Sarjoy1;
	}

	public Joystick getJoystickSar2()
	{
		return Sarjoy2;
	}

	public OI()
	{

		// Branjoy Input ===========================================================

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



		// Sarjoy Input ===========================================================
		// Extending arm positions will need to be fixed below especially
		// since we are resetting the Talon SRX starting postion to 0 now.
		// This wasn't done when we recorded the origional numbers.

		// Velcro Piston
		Arcade1.whenPressed(new VelcroPistonsToggle());

		// Pull Ball In
		Arcade2.whileHeld(new Intake(0.75));
		Arcade2.whenReleased(new Intake(0.0));

		// Shoot Ball Out
		Arcade3.whileHeld(new Intake(-1.0));
		Arcade3.whenReleased(new Intake(0.0));

		// Rocket Cargo
		Arcade4.whenPressed(new ExtendingArmMovePosition(940)); // bottom
		Arcade5.whenPressed(new ExtendingArmMovePosition(1886)); // medium
		Arcade6.whenPressed(new ExtendingArmMovePosition(2973)); // top

		// Rocket Hatch
		Arcade7.whenPressed(new ExtendingArmMovePosition(600)); // bottom
		Arcade8.whenPressed(new ExtendingArmMovePosition(1570)); // medium
		Arcade9.whenPressed(new ExtendingArmMovePosition(2682)); // top

		// Ship
		Arcade10.whenPressed(new ExtendingArmMovePosition(0)); // cargo
		Arcade11.whenPressed(new ExtendingArmMovePosition(0)); // hatch

		// Station
		Arcade12.whenPressed(new ExtendingArmMovePosition(0)); // cargo
		Arcade13.whenPressed(new ExtendingArmMovePosition(0)); // hatch

		// Arm
		Arcade14.whenPressed(new ExtendingArmMovePosition(0)); // driving
		Arcade15.whenPressed(new ExtendingArmMovePosition(0)); // ground

	}

}
