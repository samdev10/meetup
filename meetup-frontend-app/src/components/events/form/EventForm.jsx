import React from "react";
import { Field, reduxForm } from "redux-form";
import { useSelector } from "react-redux";

const EventForm = function EventForm(props) {
  const state = useSelector((state) => state);

  return (
    <form name="event" onSubmit={props.handleSubmit}>
      <div>
        <label htmlFor="name">Name : </label>
        <Field name="name" component="input" type="text" />
      </div>
      <div>
        <label htmlFor="description">Description : </label>
        <Field name="description" component="input" type="text" />
      </div>
      <div>
        <label htmlFor="dateFrom">Date From : </label>
        <Field name="dateFrom" component="input" type="date" defaultValue={new Date()}></Field>
      </div>
      <div>
        <label htmlFor="timeFrom">Time From : </label>
        <Field name="timeFrom" component="input" type="time"></Field>
      </div>
      <div>
        <label htmlFor="dateTo">Date To : </label>
        <Field name="dateTo" component="input" type="date"></Field>
      </div>
      <div>
        <label htmlFor="timeTo">Time To : </label>
        <Field name="timeTo" component="input" type="time"></Field>
      </div>
      <button type="submit">Submit</button>
    </form>
  );
};

export default reduxForm({
  form: "event",
})(EventForm);
