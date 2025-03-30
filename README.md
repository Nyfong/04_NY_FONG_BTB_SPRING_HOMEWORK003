```
create table attendees(
    attendee_id serial primary key ,
    attendee_name varchar(150),
    email varchar(150)
);

create  table venues(
    venue_id serial primary key ,
    venue_name varchar(150),
    location varchar(150)
);

create  table events(
    event_id serial primary key ,
    event_name varchar(150),
     venue_id int references venues(venue_id)  ON DELETE  CASCADE,
     event_date DATE
);

create  table event_attendee(
    id serial primary key ,
    event_id  int references  events(event_id) ON  DELETE CASCADE ,
     attendee_id int references attendees(attendee_id)  ON DELETE  CASCADE
);
```