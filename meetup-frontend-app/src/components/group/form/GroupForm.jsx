import React from "react";
import { Field, reduxForm } from "redux-form";

const GroupForm = function GroupForm(props) {

  return (
    <form name="group" onSubmit={props.handleSubmit}>
      <div className="form-group">
        <label htmlFor="name">Name</label>
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
      <button className="btn btn-primary" type="submit">Submit</button>
    </form>
  );
};

export default reduxForm({
  form: "group",
})(GroupForm);
