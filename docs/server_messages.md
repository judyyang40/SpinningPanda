- New player joining

    *request:
    ```
    {
        "action": "join",
        "name": "Player Name"
    }
    
    ```
    *response:
    ```
    {
        "id": player_id;
    }
    ```

- Player ready

    *requst:
    ```
    {
        "action": "ready",
        "id": player_id
    }
    ```
    
    *response:
    ```
    {
        "running": true|false
    }
    ```

- Player moves

    *request:
    ```
    {
        "action": "move",
        "destination": island_id;
    }

    ```
    *response:
    ```
    {
        "running": true|false
    }
    ```

- Player finishes

    *request:
    ```
    {
        "action": "finish"
    }
    ```

    *response:
    ```
    {
        "running": true|false;
    }
    ```

- Player queries progress

    *request:
    ```
    {
        "action": "query"
    }
    ```

    *response:
    ```
    {
        "running": true|false,
        "standing":
        {
            player_id:island_id,
            ...
        }
    }
    ```
