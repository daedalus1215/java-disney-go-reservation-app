import React from "react";
import { render } from "@testing-library/react";
import HomePage from "../HomePage";

test("should render HomePage", () => {
  // Arrange
  const { container } = render(<HomePage />);

  // Act

  // Assert
  expect(container.firstChild).toMatchInlineSnapshot(`
    <div>
      HomePage!
      <div>
        This will be a listview
      </div>
      <div>
        Reservation Form
      </div>
    </div>
  `);
});
