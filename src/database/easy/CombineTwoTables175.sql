SELECT per.firstname, per. lastname, ad.city, ad.state
FROM Person per
LEFT JOIN Address ad ON per.personId=ad.personId;
