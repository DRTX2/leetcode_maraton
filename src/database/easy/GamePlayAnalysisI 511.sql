select player_id, min(event_date) as first_login
from Activity
group by player_id
order by player_id;

SELECT player_id,MIN( event_date) as first_login from Activity
group by player_id