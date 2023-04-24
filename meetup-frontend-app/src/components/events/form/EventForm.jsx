import React from "react";
import { Field, reduxForm } from "redux-form";
import { useSelector } from "react-redux";

const EventForm = function EventForm(props) {
  const state = useSelector((state) => state);

  return (
    <form name="event" onSubmit={props.handleSubmit}>
      <div>
        <label htmlFor="name">Name</label>
        <Field name="name" component="input" type="text" />
      </div>
      <div>
        <label htmlFor="description">Description</label>
        <Field name="description" component="input" type="text" />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
};

export default reduxForm({
  form: "event",
})(EventForm);
