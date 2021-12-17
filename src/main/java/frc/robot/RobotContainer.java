// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.DrivetrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	public Joystick driverJoystick;
	public DrivetrainSubsystem drivetrainSubsystem;

	/** The container for the robot. Contains subsystems, OI devices, and commands. */
	public RobotContainer() {
		driverJoystick = new Joystick(OIConstants.DRIVER_JOYSTICK_PORT);
		drivetrainSubsystem = new DrivetrainSubsystem();

		// Configure the button bindings
		configureButtonBindings();
	}

	/**
 	* Use this method to define your button->command mappings. Buttons can be created by
 	* instantiating a {@link GenericHID} or one of its subclasses ({@link
 	* edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
 	* edu.wpi.first.wpilibj2.command.button.JoystickButton}.
 	*/
	private void configureButtonBindings() {}

	public double getLeftY() {
        return -driverJoystick.getRawAxis(0);
    }

    public double getLeftX() {
        return driverJoystick.getRawAxis(1);
    }

    public double getRightY() {
        return -driverJoystick.getRawAxis(2);
    }

    public double getRightX() {
        return driverJoystick.getRawAxis(3);
    }

	private void setJoystickButtonWhenPressed(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}

	private void setJoystickButtonWhileHeld(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whileHeld(command);
	}

	/**
 	* Use this to pass the autonomous command to the main Robot class.
 	*
 	* @return the command to run in autonomous
 	*/
	public Command getAutonomousCommand() {
		return new CommandBase() {};
	}
}
