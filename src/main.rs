use actix_web::{post, App, HttpResponse, HttpServer, Responder};

#[post("/")]
async fn upload_file() -> impl Responder {
    HttpResponse::Ok().body("Hello")
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    HttpServer::new(|| {
        App::new()
            .service(upload_file)
    })
    .bind(("127.0.0.1", 8080))?
    .run()
    .await
}
