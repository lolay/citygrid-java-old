#!/bin/bash
# -v for in/out
curl -i -X GET http://api.citygridmedia.com/search/events?type=movie\&where=90069\&publisher=acme\&format=xml

#/search/locations?type=movietheater&where=90045