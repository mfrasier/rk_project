# rk_project

Sample web app to retrieve records from imdb for an actor.
Returned in json format.

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a test web server for the application, run:

    lein ring server
    -or-
    lein run -m rk_project.handler

example queries:
    REST-like   : http://localhost:<port>/actor/Jennifer+Garner
    query string: http://localhost:<port>/actor?name=Jennifer+Garner

## License

Copyright © 2014 
