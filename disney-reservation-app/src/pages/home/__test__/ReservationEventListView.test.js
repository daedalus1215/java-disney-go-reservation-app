import React from "react";
import { render } from "@testing-library/react";
import ReservationEventListView from "../ReservationEventListView";

describe("src/pages/home/__test__/ReservationEventListView", () => {
  describe("ReservationEventListView", () => {
    it("should...", () => {
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
  });
});
