import React from "react";
import { Field, reduxForm } from "redux-form";

const EventForm = function EventForm(props) {
  return (
    <form name="event" onSubmit={props.handleSubmit}>
      <div className="form-group">
        <label htmlFor="name">Event Name</label>
        <Field
          className="form-control"
          name="name"
          component="input"
          type="text"
        />
      </div>
      <div className="form-group">
        <label htmlFor="description">Description</label>
        <Field
          className="form-control"
          name="description"
          component="input"
          type="text"
        />
      </div>
      <div className="form-group">
        <label htmlFor="startTime">Start Time</label>
        <Field
          className="form-control"
          name="eventStartTime"
          component="input"
          type="datetime-local"
        ></Field>
      </div>
      <div className="form-group">
        <label htmlFor="endTime">End Time</label>
        <Field
          className="form-control"
          name="eventEndTime"
          component="input"
          type="datetime-local"
        ></Field>
      </div>
      <button className="btn btn-primary" type="submit">Submit</button>
    </form>
  );
};

export default reduxForm({
  form: "event",
})(EventForm);
