#!/bin/bash
# -v for in/out
curl -i -X GET http://api.citygridmedia.com/search/locations?type=restaurant\&where=90045\&publisher=csmobile\&format=xml

#/search/locations?type=movietheater&where=90045