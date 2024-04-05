package com.tobeto.pairwork_orm.services.concretes;

import com.tobeto.pairwork_orm.entities.ProductPhoto;
import com.tobeto.pairwork_orm.repositories.ProductPhotoRepository;
import com.tobeto.pairwork_orm.services.abstracts.ProductPhotoService;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.DeleteProductPhotoRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.requests.GetProductPhotosRequest;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.DeleteProductPhotoResponse;
import com.tobeto.pairwork_orm.services.dtos.productPhotoDtos.responses.GetProductPhotosResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {

	private ProductPhotoRepository productPhotoRepository;

	@Override
	public List<GetProductPhotosResponse> getProductPhotosByProductId(
			GetProductPhotosRequest request) {

		/*List<ProductPhoto> productPhotos = productPhotoRepository
				.getProductPhotosByProduct_ProductId(request.getProductId());

		List<GetProductPhotosResponse> response = new ArrayList<>();

		for (ProductPhoto dto : productPhotos) {
			GetProductPhotosResponse photoResponse = this.modelMapperService.forResponse().map(dto,
					GetProductPhotosResponse.class);

			response.add(photoResponse);
		}*/

		return null;
	}

	@Override
	public DeleteProductPhotoResponse delete(DeleteProductPhotoRequest request) {

		ProductPhoto photo = productPhotoRepository.findById(request.getId()).orElseThrow();

		productPhotoRepository.delete(photo);

		DeleteProductPhotoResponse response = new DeleteProductPhotoResponse("Product photo deleted.");

		return response;
	}

}
