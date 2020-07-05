import React from "react";
import { render } from "@testing-library/react";
import ReservationEventListView from "../listview/ReservationEventListView";

test("should render ReservationEventListView", () => {
  // Arrange
  const { container } = render(<ReservationEventListView />);

  // Act

  // Assert
  expect(container.firstChild).toMatchInlineSnapshot(`
        <div>
          This will be a listview
        </div>
      `);
});
