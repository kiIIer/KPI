FROM node:17.4.0-alpine3.14 AS build
WORKDIR /app
COPY package*.json .
RUN npm ci
COPY ./ .
RUN npm run build

FROM nginx:1.21.6-alpine
RUN rm /etc/nginx/nginx.conf
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /app/dist/maid-simp /usr/share/nginx/html
