# cheshire-cat

FIXME

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

    lein ring server-headless

    lein cljsbuild auto

    lein trampoline cljsbuild repl-rhino

    lein trampoline cljsbuild repl-listen

You can also start the web server with 
    
    lein ring server-headless

This will start up the web server and not open a new window for you

## License

Copyright © 2020 FIXME
