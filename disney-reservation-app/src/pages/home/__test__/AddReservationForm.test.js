import React from "react";
import { render } from "@testing-library/react";
import AddReservationForm from "../AddReservationForm";

test("should render AddReservationForm", () => {
  // Arrange
  const { container } = render(<AddReservationForm />);

  // Act

  // Assert
  expect(container.firstChild).toMatchInlineSnapshot(`
    <div>
      Reservation Form
    </div>
  `);
});
